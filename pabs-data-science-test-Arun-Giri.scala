// Databricks notebook source
//File stores

///FileStore/tables/sessions.csv
///FileStore/tables/users.csv
///FileStore/tables/video_plays.csv


// COMMAND ----------

val sessions = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/FileStore/tables/sessions.csv")
val users = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/FileStore/tables/users.csv")
val videoplays = sqlContext.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("/FileStore/tables/video_plays.csv")

sessions.createOrReplaceTempView("sessions")
users.createOrReplaceTempView("users")
videoplays.createOrReplaceTempView("videoplays")

// COMMAND ----------

//** Observations**//
//Users spent maximum time watching live tv ..

val max_time_spent = spark.sql("""select v.watch_type,v.station, max(v.viewed_seconds) from sessions s join videoplays v on s.user_id=v.user_id group by v.watch_type,v.station order by max(v.viewed_seconds) desc""")

display(max_time_spent)

// COMMAND ----------

//** Observations**//
// NBABasketball-LosAngelesLakersatLosAngelesClippers was most viewed_seconds

val videoplay = spark.sql("""select program_title,viewed_seconds,device_model from videoplays v join sessions s on v.user_id=s.user_id group by program_title,device_model,viewed_seconds,s.user_id order by viewed_seconds desc """)


display(videoplay)

// COMMAND ----------

//** Observations**//
// user spent watching watching basket ball game on 6 different devices all at same time

val program_watched_on_devices = spark.sql("""select distinct s.user_id,v.timestamp,s.device_model,program_title,max(viewed_seconds) as tm  from videoplays v join sessions s on v.user_id=s.user_id where s.user_id='YveqeouqFl/bQ8UTku4DqHITzmee1Jzy0kldfsQ+YtQ=' group by s.device_model,program_title,s.user_id,v.timestamp order by  tm desc """)


display(program_watched_on_devices)

// COMMAND ----------

//Daily users  count chart

val daily = spark.sql("""select count(distinct s.user_id),cast(s.start_timestamp as date) from sessions s join videoplays v on s.user_id=v.user_id and s.session_id=v.session_id where v.timestamp BETWEEN s.start_timestamp and s.end_timestamp group by cast(s.start_timestamp as date) """)

display(daily)

// COMMAND ----------

//Weekly users count chart
val weekly = spark.sql("""select count(distinct s.user_id),cast(s.start_timestamp as date) from sessions s join videoplays v on s.user_id=v.user_id and s.session_id=v.session_id where v.timestamp BETWEEN s.start_timestamp and s.end_timestamp -INTERVAL 1 WEEK group by cast(s.start_timestamp as date) order by  cast(s.start_timestamp as date)""")

display(weekly)

// COMMAND ----------

// Percentage of daily users
val daily_percentage = spark.sql("""select count(distinct s.user_id),cast(s.start_timestamp as date),(count(distinct s.user_id)*100 / sum(count(s.user_id)) over ())*100 as session_percent from sessions s join videoplays v on s.user_id=v.user_id and s.session_id=v.session_id where v.timestamp BETWEEN s.start_timestamp and s.end_timestamp group by cast(s.start_timestamp as date) """)

display(daily_percentage)

// COMMAND ----------

// Percentage of weekly users

val weekly_percentage = spark.sql("""select count(distinct s.user_id),cast(s.start_timestamp as date),(count(distinct s.user_id) * 100 /sum(count(s.user_id)) over ()) * 100 as session_percent from sessions s join videoplays v on s.user_id=v.user_id and s.session_id=v.session_id where v.timestamp BETWEEN s.start_timestamp and s.end_timestamp -INTERVAL 1 WEEK group by cast(s.start_timestamp as date) """)

display(weekly_percentage)

// COMMAND ----------

// Percentage of users who spent viewing videos more than 10 secs
val ten_sec_percentage = spark.sql("""SELECT 
    distinct(
        (SELECT COUNT(*) FROM videoplays WHERE viewed_seconds>10 ) 
        / (SELECT COUNT(*) FROM videoplays) 
        * 100
    ) AS login_10_percent 
FROM videoplays""")

display(ten_sec_percentage)
