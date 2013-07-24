/*
 * (C) 2010-2012 ICM UW. All rights reserved.
 */

package pl.edu.icm.coansys.citations.data

import feature_calculators._
import pl.edu.icm.coansys.citations.util.SvmClassifier
import pl.edu.icm.coansys.citations.util.classification.features.FeatureVectorBuilder

/**
 * @author Mateusz Fedoryszak (m.fedoryszak@icm.edu.pl)
 */
class SimilarityMeasurer {
  val featureVectorBuilder = new FeatureVectorBuilder(List(
    AuthorTrigramMatchFactor,
    AuthorTokenMatchFactor,
    PagesMatchFactor,
    SourceMatchFactor,
    TitleMatchFactor,
    YearMatchFactor))

  val classifier = SvmClassifier.fromResource("/pl/edu/icm/coansys/citations/weakMatching.model")

  def similarity(e1: MatchableEntity, e2: MatchableEntity): Double =
    classifier.predictProbabilities(featureVectorBuilder.calculateFeatureVectorValues((e1, e2)))(1)
}

object SimilarityMeasurer {
  def main(args: Array[String]) {
    val measurer = new SimilarityMeasurer
    val doc1 = MatchableEntity.fromParameters("1", "Jan Kowalski", "J. App. Phis.", "Some random title", "120-126", "2010")
    val doc2 = MatchableEntity.fromParameters("2", "Jan Kowalski", "J. App. Phis.", "Totally different title", "32-36", "2010")
    val doc3 = MatchableEntity.fromParameters("3", "Zbigniew Nowak", "Przegląd leśniczy", "Inny tytuł", "15-20", "1995")
    println(measurer.similarity(doc1, doc1))
    println(measurer.similarity(doc1, doc2))
    println(measurer.similarity(doc1, doc3))

  }
}
