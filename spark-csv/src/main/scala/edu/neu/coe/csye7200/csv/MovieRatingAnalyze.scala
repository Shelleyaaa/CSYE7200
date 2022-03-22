package edu.neu.coe.csye7200.csv

import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SparkSession}

object MovieRatingAnalyze extends App {

  def apply(resource: String): MovieRatingAnalyze = new MovieRatingAnalyze(resource)

  apply("/movie_metadata.csv").mean("imdb_score").show()

  apply("/movie_metadata.csv").std("imdb_score").show()

}

case class MovieRatingAnalyze(resource: String) {

  val spark: SparkSession = SparkSession
    .builder()
    .appName("MovieRatingAnalyze")
    .master("local[*]")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  val path: String = getClass.getResource(resource).getPath
  val df = spark.read.option("delimiter", ",").option("header", "true").csv(path)

  def mean(column: String): DataFrame = df.select(avg(column))

  def std(column: String): DataFrame = df.select(stddev(column))

}
