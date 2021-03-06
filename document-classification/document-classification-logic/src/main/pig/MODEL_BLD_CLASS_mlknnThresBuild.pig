--
-- This file is part of CoAnSys project.
-- Copyright (c) 2012-2013 ICM-UW
-- 
-- CoAnSys is free software: you can redistribute it and/or modify
-- it under the terms of the GNU Affero General Public License as published by
-- the Free Software Foundation, either version 3 of the License, or
-- (at your option) any later version.

-- CoAnSys is distributed in the hope that it will be useful,
-- but WITHOUT ANY WARRANTY; without even the implied warranty of
-- MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
-- GNU Affero General Public License for more details.
-- 
-- You should have received a copy of the GNU Affero General Public License
-- along with CoAnSys. If not, see <http://www.gnu.org/licenses/>.
--

DEFINE mlknnThresBuild(part,DEF_NEIGH) RETURNS ret{
	B1 = foreach $part generate flatten(pl.edu.icm.coansys.classification.
                documents.pig.proceeders.POS_NEG(keyA,keyB,categsA,categsB)) as (keyA, categQ, pos, neg);
	B2 = group B1 by (keyA,categQ);
	B3 = foreach B2 generate group.keyA as keyA, group.categQ as categQ, SUM(B1.pos) as pos, SUM(B1.neg) as neg;

	split B3 into
        	B3pos if pos>0,
	        B3neg if neg>0;
	B4pos = group B3pos by (categQ,pos);
	pos = foreach B4pos generate group.categQ as categQ, group.pos as neigh, COUNT(B3pos) as docsocc;
	posX = group pos by categQ;
	posXs = order posX by categQ asc;
	
	B4neg = group B3neg by (categQ,neg);
	neg = foreach B4neg generate group.categQ as categQ, group.neg as neigh, COUNT(B3neg) as docsocc;
	negX = group neg by categQ;
	negXs = order negX by categQ asc;

	$ret = join posX by categQ full outer,negX by categQ using 'merge'; -- (group::posX::categ),pos::{(categ,count,docscount)}, (group::negX::categ),neg::{(categ,count,docscount)}?
/*
	allX6 = join posX by categQ full outer,negX by categQ using "merge"; -- (group::posX::categ),pos::{(categ,count,docscount)}, (group::negX::categ),neg::{(categ,count,docscount)}?

	retX = foreach allX6 generate FLATTEN(pl.edu.icm.coansys.classification.
                documents.pig.proceeders.THRES_FOR_CATEG(*,'$DEF_NEIGH'))
                as (categ:chararray, thres:int, f1:double);
	$ret = filter retX by $0 is not null;
*/
};
/*
DEFINE mlknnThresBuild(part,DEF_NEIGH) RETURNS ret{
	split $part into 
		posX if (categA == categQ
				and categB == categQ), -- keyA, keyB, categA, categB, part, categQ; 
		negX if (categA != categQ
				and categB == categQ); -- keyA, keyB, categA, categB, part, categQ;

	pos = calcCategNeighDocs(posX); --(categ),{(categ,count,docscount)}
	neg = calcCategNeighDocs(negX);

	allX6 = join pos by $0,neg by $0; -- (categPOS),POS::{(categ,count,docscount)}, (categNEG),NEG::{(categ,count,docscount)}?
	$ret = foreach allX6 generate FLATTEN(pl.edu.icm.coansys.classification.
		documents.pig.proceeders.THRES_FOR_CATEG(*,$DEF_NEIGH)) 
		as (categ:chararray, thres:int, f1:double);
};
*/
/*PRIVATE*/ DEFINE calcCategNeighDocs(tab) RETURNS ret{
        tabX2 = group $tab by (keyA, categB) parallel 16; -- (keyA,categA), {(keyA, keyB, categA, categB, tab, categQ)}; np. 3 sąsiadów ma categB==categQ
        tabX3 = foreach tabX2 generate group.categA as categ, COUNT($tab) as neigh; -- categ, 3;
        tabX4 = group tabX3 by (categ,neigh) parallel 16; -- (categ,count),{(categ,count)};
        tabX5 = foreach tabX4 generate flatten(group), COUNT(tabX3) as docsocc; -- np kod 12345 wystąpił u 3 sąsiadów w 7 dokumentach
        tabX5A = order tabX5 by neigh asc parallel 16;
        $ret = group tabX5 by categ parallel 16; --(categ),{(categ,count,docscount)}
};


/*PRIVATE*/
/*
DEFINE calcCategNeighDocs(tab) RETURNS ret{
        tabX2 = group $tab by (keyA, categA); -- (keyA,categA), {(keyA, keyB, categA, categB, categQ)}; np. 3 sąsiadów ma categB==categA
        tabX3 = foreach tabX2 generate group.categA as categ, COUNT($tab) as neigh; -- categ 123 wyst u 3sasiadow;
        pos = group tabX3 by categ; --(categ),{(categ,count)}

};
*/

