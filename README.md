# Data Science Project

1) Create a Daily/weekly/monthly users Line chart.

2) What % of users generate a "Video Play" event daily/weekly/monthly?

3) What % of sessions involve a video play event that lasts longer than, say, 10 seconds?

4) Open Ended -- We'd like you to explore this data set on your own, learn what you can about it, and show us your results! With apps like these (i.e. Video apps), we as data scientists are particularly interested customer "engagement" -- how long they are spending in app, how often they are using it, what they are using it for, etc. -- but don't restrict yourself to investigating only these sorts of questions; we want to know how you think!

# Data Sets

#### session_model 

| field | type | description |
| ------------- | ------------- | ------------- |
| timestamp | timestamp | event timestamp |
| user_id | string | user identity |
| device_id | string | device identity |
| session_uuid | string | session identity |
| birth_date | long | first time seen |
| device_type | string | device model | 
| pages_viewed | integer | pages viewed |
| session_number | integer | session number |


#### video_model 

| field | type | description |
| ------------- | ------------- | ------------- |
| timestamp | timestamp | session close timestamp |
| user_id | string | user identity |
| device_id | string | device identity |
| session_uuid | string | session identity |
| Entity | string | entity identity |
| viewed_pct | string | viewed percentage |
| viewed_secs | string | viewed seconds |
| duration_secs | string | entity duration |
| content_name | string | content name |
| provider | string | provider name |
| station | string | station name |
| season | string | season number |
| episode | string | episode number |
| type | string | viewing type |
| rights_type | string | rights type |

