# godLife

## 작업순서 
### 기획
1. 화면 명세
2. ERD 설계
3. API 명세

### 개발환경 세팅
1. git 저장소 생성
2. Spring io Initializer 생성
3. MariaDB 10.6.15 버전 로컬 설치
4. 프로젝트에 Java 17 세팅
5. Spring Boot 구동 성공  

## ERD
![God Life ERD](/images/godLife.drawio.new.png)


## API 명세서

#### 1. 게시글 조회 (단일) - read
request
```
GET:/api/post/{post_no}?board_no=1
```
response
```javascript
{
	"title" : "오늘 러닝했어요",
	"contents" : "오늘은 5km를 뛰었어요. 회원님들은 얼마나 뛰셨나요?",
	"writer" : "김철수",
	"ins_timestamp" : "2023-10-10 17:30:00",
	"reactions" : {
		"like" : 50,
		"cheering" : 10,
		"awesome" : 30,
		"funny" : 20,
	},
	"reply": [
		{
			"contents" : "와 대단해요. 저는 오늘 3km 뛰었어요.",
			"writer" : "김영희",
			"ins_timestamp" : "2023-10-10 17:50:00",
		},
		{
			"contents": "저는 오늘 문밖에 못나갔습니다ㅋㅋ.. 회원님들 대단해요!",
			"writer": "최민지",
			"ins_timestamp": "2023-10-10 20:50:00",
		}
	]
}
```

#### 2. 게시글 조회 (리스트) - read
request
```
GET:/api/post/title?board_no=1&limit=10&offset=0&sort=ins_timestamp_desc
```
response
```javascript
[
	{
		"board_no": 4,
		"title": "오늘 러닝했어요",
		"ins_timestamp": "2023-10-10 22:30:00",
	}, 
	{
		"board_no": 3,
		"title": "오늘 일기썼습니다",
		"ins_timestamp": "2023-10-10 21:30:00",
	},
	{
		"board_no": 2,
		"title": "오늘 시험 합격했어요",
		"ins_timestamp": "2023-10-10 20:30:00",
	},
	{
		"board_no": 1,
		"title": "기분이 좋아요",
		"ins_timestamp": "2023-10-10 19:30:00",
	}
]
```
#### 3. 게시글 등록 - create
request
```javascript
POST:/api/post
{
        "board_no" : 1,
	"title" : "오늘 러닝했어요",
	"contents" : "오늘은 5km를 뛰었어요. 회원님들은 얼마나 뛰셨나요?",
}
```
response
```
201 Created
```
#### 4. 게시글 수정 - update
request
```javascript
PUT:/api/post/{post_no}
{
        "board_no" : 1,
	"title" : "오늘 러닝했어요 D+11",
	"contents" : "오늘은 5km를 뛰었어요. 11일 차에요. 회원님들은 얼마나 뛰셨나요?"
}
```
response
```
200 OK
```

#### 5. 게시글 삭제 - delete
request
```
DELETE:/api/post/{post_no}
```
response
```
204 No Content
```

#### 6. 반응 생성 - create
request
```
POST:/api/post/{post_no}/reaction/{reaction_no}
```
response
```
201 Created
```

#### 7. 반응 삭제 - delete
request
```
DELETE:/api/board/{board_no}/reaction/{reaction_no}
```
response
```
204 No Content
```

#### 8. 댓글 생성 - create
request
```javascript
POST:/api/post/{post_no}/reply
{
	"contents" : "대단해요!"
}
```
response
```
201 Created
```

#### 9. 댓글 삭제 - delete
request
```
DELETE:/api/post/{post_no}/reply/{reply_no}
```
response
```
204 No Content
```

#### 10. 반응 종류 조회 API - read
request
```
GET:/api/reactions
```
response	
```javascript
[
	{
		"reaction_no" : 1,
		"reaction_title" : "좋아요"
	},
	{
		"reaction_no" : 2,
		"reaction_title" : "응원해요"
	},
	{
		"reaction_no" : 3,
		"reaction_title" : "멋져요"
	},
	{
		"reaction_no" : 4,
		"reaction_title" : "재밋어요"
	}
]
```




