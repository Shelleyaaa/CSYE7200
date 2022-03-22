package edu.neu.coe.csye7200.csv

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.Try

class MovieRatingAnalyzeTest extends AnyFlatSpec with Matchers {

  behavior of "Spark"

  it should "get path correctly" in {
    val pathTry = Try(MovieRatingAnalyze("/movie_metadata.csv").path)
    pathTry.isSuccess shouldBe true
  }

  it should "get dataFrame correctly" in {
    val dfTry = Try(MovieRatingAnalyze("/movie_metadata.csv").df)
    dfTry.isSuccess shouldBe true
    for (df <- dfTry) df.count() shouldBe 1609
  }

  it should "calculate mean method correctly" in {
    MovieRatingAnalyze("/movie_metadata.csv").mean("imdb_score").head().getDouble(0) shouldBe 6.4532 +- 1E-4
  }

  it should "calculate std method correctly" in {
    MovieRatingAnalyze("/movie_metadata.csv").std("imdb_score").head().getDouble(0) shouldBe 0.9988 +- 1E-4
  }

}
