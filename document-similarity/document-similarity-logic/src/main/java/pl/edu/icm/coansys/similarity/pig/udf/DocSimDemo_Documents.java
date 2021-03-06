/*
 * This file is part of CoAnSys project.
 * Copyright (c) 2012-2013 ICM-UW
 * 
 * CoAnSys is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * CoAnSys is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with CoAnSys. If not, see <http://www.gnu.org/licenses/>.
 */

package pl.edu.icm.coansys.similarity.pig.udf;

import java.io.IOException;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataByteArray;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.tools.pigstats.PigStatusReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.edu.icm.coansys.commons.java.DiacriticsRemover;
import pl.edu.icm.coansys.commons.java.StackTraceExtractor;
import pl.edu.icm.coansys.models.DocumentProtos.DocumentMetadata;
import pl.edu.icm.coansys.models.DocumentProtos.DocumentWrapper;
import pl.edu.icm.coansys.models.DocumentProtos.TextWithLanguage;

/**
 * 
 * @author pdendek
 *
 */
public class DocSimDemo_Documents extends EvalFunc<Tuple> {

	private static final Logger logger = LoggerFactory.getLogger(DocSimDemo_Documents.class);
	PigStatusReporter myreporter;
		
    @Override
    public Tuple exec(Tuple input) throws IOException {
    	
    	myreporter = PigStatusReporter.getInstance();
	
		if (input == null || input.size() == 0) {
			return null;
		}

		try {
			DataByteArray dba = null;
			DocumentMetadata dm = null;
			String title = null;
			String doi = null;
			String year = null;
			
			try{
				dba = (DataByteArray) input.get(0);
			}catch(Exception e){
				myreporter.getCounter("extraction problems","DataByteArray from tuple");
				return null;
			}
			
			try{
				dm = DocumentWrapper.parseFrom(dba.get()).getDocumentMetadata();
			}catch(Exception e){
				myreporter.getCounter("extraction problems","document metadata");
				return null;
			}
			
			try{
				for(TextWithLanguage twl : dm.getBasicMetadata().getTitleList()){
					if(twl.getLanguage().toLowerCase().startsWith("en")){
						title=twl.getText();
						
						break;
					}
				}
				if(title==null){
					title = dm.getBasicMetadata().getTitle(0).getText();
				}
				if(title != null && !title.trim().isEmpty()){
					title = DiacriticsRemover.removeDiacritics(title);
					title = title.replaceAll("[^A-Za-z0-9\\-_]", " ").replaceAll("\\s++", " ").trim();
				}
			}catch(Exception e){
			}finally{
				if(title == null || title.trim().isEmpty()){
					myreporter.getCounter("extraction problems","title extraction");
					return null;
				}
			}
			
			try{
				doi = dm.getBasicMetadata().getDoi().replaceAll("\\s++", " ").trim();
			}catch(Exception e){
			}finally{
				if(doi == null || doi.trim().isEmpty()){
					myreporter.getCounter("extraction problems","doi extraction");
					return null;
				}
			}
			
			try{
				year = dm.getBasicMetadata().getYear().replaceAll("\\s++", " ").trim();
			}catch(Exception e){
			}finally{
				if(year == null || year.trim().isEmpty()){
					myreporter.getCounter("extraction problems","year extraction");
					return null;
				}
			}
			
			Tuple t = TupleFactory.getInstance().newTuple();
			t.append(doi);
			t.append(year);
			t.append(title);
			
			return t;
		}catch(Exception e){
			logger.debug(StackTraceExtractor.getStackTrace(e));
			throw new IOException(e);
		}
	}
    
    public static void main(String[] args){
    	String title = "a\n\nb\t\tc\r\rd";
    	title = title.replaceAll("[\\p{Space}]+", " ");
    	System.out.println(title);
    }
    
}