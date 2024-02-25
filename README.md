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
![God Life ERD](/images/godLife.erd.240225.png)


## API 명세서

#### 1. 게시글 조회 (단일) - read
request
```
GET:/api/post/{post_no}?board_no=1
```
response
```javascript
{
	"post_title" : "오늘 러닝했어요",
	"post_contents" : "오늘은 5km를 뛰었어요. 회원님들은 얼마나 뛰셨나요?",
	"post_writer" : "김철수",
	"ins_timestamp" : "2023-10-10 17:30:00"
}
```

#### 2. 게시글 제목 조회 (리스트) - read
request
```
GET:/api/post/title?board_no=1&limit=10&page=1&sort=ins_timestamp_desc
```
response
```javascript
[
	{
		"post_no": 4,
		"title": "오늘 러닝했어요",
		"ins_timestamp": "2023-10-10 22:30:00",
	}, 
	{
		"post_no": 3,
		"title": "오늘 일기썼습니다",
		"ins_timestamp": "2023-10-10 21:30:00",
	},
	{
		"post_no": 2,
		"title": "오늘 시험 합격했어요",
		"ins_timestamp": "2023-10-10 20:30:00",
	},
	{
		"post_no": 1,
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
        "writer" : "Lucy",
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
        "writer" : "Lucy",
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

#### 6. 게시글 반응 조회 - get 
request
```
GET:/api/post/{post_no}/reaction
```
response
```
[
	{
		"reaction_type": "L",
		"total_count": 236
	}, 
	{
		"reaction_type": "F",
		"total_count": 119
	},
        {
		"reaction_type": "I",
		"total_count": 12
	}
]
```

#### 7. 댓글 생성 - create
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

#### 8. 댓글 조회 - create
request
```javascript
GET:/api/post/{post_no}/reply?limit=10&page=1&sort=ins_timestamp_desc
[
	{
		"reply_no" : 1,
		"contents" : "와 대단해요. 저는 오늘 3km 뛰었어요.",
		"ins_user" : "김영희",
		"ins_timestamp" : "2023-10-10 17:50:00",
		"reactions" : [
			{
				"reaction_type": "L",
				"total_count": 10
			}, 
			{
				"reaction_type": "F",
				"total_count": 5
			}
		]
	},
	{
		
		"reply_no" : 1,
		"contents": "저는 오늘 문밖에 못나갔습니다ㅋㅋ.. 회원님들 대단해요!",
		"ins_user": "최민지",
		"ins_timestamp": "2023-10-10 20:50:00",
		"reactions" : [
			{
				"reaction_type": "L",
				"total_count": 10
			}, 
			{
				"reaction_type": "O",
				"total_count": 5
			}
		]
	}
]
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
GET:/api/reaction
```
response	
```javascript
[
	{
		"reaction_title" : "좋아요",
		"reaction_type" : "L"
	},
	{
		"reaction_title" : "응원해요",
		"reaction_type" : "F"
	},
	{
		"reaction_title" : "재밋어요",
		"reaction_type": "I"
	},
	{
		"reaction_title" : "괜찮아요",
		"reaction_type": "O"
	}
]
```

#### 11. 반응 생성 - create
request
```
Uri : POST:/api/reaction/{reaction_type}
Request Body : 
// 예시1. 게시글에 대한 반응 
{
    "post_no" : 3,
    "ins_user" : "lucy"
}
// 예시2. 댓글에 대한 반응
{
    "reply_no" : 3,
    "ins_user" : "lucy"
}
```
response
```
201 Created
// 예시1. 게시글에 대한 반응
{
    "mapping_no": 2,
    "post_no": 3,
    "reply_no": null,
    "reaction_type": "L",
    "ins_user": "lucy"
}
// 예시2. 댓글에 대한 반응

{
    "mapping_no": 3,
    "post_no": null,
    "reply_no": 3,
    "reaction_type": "L",
    "ins_user": "lucy"
}
```


#### 12. 반응 삭제 - delete
request
```
// 게시글에 대한 반응 삭제
DELETE:/api/reaction/{reaction_type}?post_no=3&ins_user=lucy
// 댓글에 대한 반응 삭제
DELETE:/api/reaction/{reaction_type}?reply_no=7&ins_user=jhh
```
response
```
204 No Content
```


#### 13. 게시판 조회 - get (23.12.31 추가)
requset 
```
GET:/api/board
```
response
```
[
    {
        "board_no": 1,
        "board_title": "느긋하게"
    },
    {
        "board_no": 2,
        "board_title": "조화롭게"
    },
    {
        "board_no": 3,
        "board_title": "활기차게"
    }
]
```
