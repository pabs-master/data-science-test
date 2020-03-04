# PABS Data Science Coding Challenge

Comcast customers use the Xfinity Stream App to watch live TV, On Demand, and DVR recordings on a variety of personal devices, such as phones and tablets.  As a data scientist, we'd like your help assessing customer engagement with the app.  Based on the provided datasets in this repository, complete the following:

1. Create charts for daily and weekly user counts.
2. Identify what percentage of users play a video on a daily and weekly basis.
3. Identify what percentage of sessions involve a video play lasting longer than 10 seconds.

In addition to the tasks above, we'd also like you explore the data on your own and share any insights you can derive with us.  Engagement is a key focus for the Stream App, so some things to consider might be how long users are spending in the app, how often they are using it, or what they are using it for.  But don't restrict yourself to investigating only these questions, we want to know what you find interesting from the data.

## Datasets

#### Users
Contains a record for all users of the Stream App.

| Field | Type | Description |
| ----- | ---- | ----------- |
| user_id | String | A unique identifier for the user |
| user_first_seen | Timestamp | The first time the user used the Stream App |

#### Sessions
A session is recorded each time a user uses the Stream App.

| Field | Type | Description |
| ----- | ---- | ----------- |
| session_id | String | A unique identifier for the session |
| user_id | String | A unique identifier for the user |
| start_timestamp | Timestamp | The starting time of the session |
| end_timestamp | Timestamp | The ending time of the session |
| device_id | String | A unique identifier for the device used for this session |
| device_model | String | The model of the device used for this session |
| pages_viewed | Integer | The number of pages viewed in the Stream App during this session |

#### Video Plays
A video play is recorded each time a user watches a program in the Stream App.

| Field | Type | Description |
| ----- | ---- | ----------- |
| session_id | String | A unique identifier for the session |
| user_id | String | A unique identifier for the user |
| timestamp | Timestamp | The starting time of the video play |
| watch_type | String | The type of video play, such as Live, On Demand, or DVR |
| provider | String | The provider of the program |
| station | String | The name of the station playing the program |
| program_title | String | The title of the program |
| program_duration_seconds | Integer | The total duration of the program |
| viewed_seconds | Integer | The amount of time the user spent watching the program |

## Deliverables

Using whatever coding language you're most comfortable with, please submit well-commented code with your answers to the questions above and your additional investigation.  Jupyter notebooks are the preferred output format, but not required.  A person should be able to read your submission and understand your thought process.  If you use any special libraries to produce your results, please note them and provide instructions so that we can re-run your code if necessary.
