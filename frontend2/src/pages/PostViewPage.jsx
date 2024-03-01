import React, { useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import styled from "styled-components";
import CommentList from "../components/List/CommentList";
import TextInput from "../components/ui/TextInput";
import Button from "../components/ui/Button";

const Wrapper = styled.div`
    padding: 16px;
    width: calc(100% -32px);
    display: flec;
    flex-direction: column;
    align-items: center;
    justify-content: center;

`;

const Continer = styled.div`
    width: 100%;
    max-width:720px;

    & > * {
        :not(:last-child) {
            margin-bottom: 16px;
        }
    }

`;

const PostContainer = styled.div`
    padding: 8px 16px;
    border: 1px solid grey;
    border-redius: 8px;
`;
 
const TitleText= styled.p`
    font-size: 28px;
    font-weight: 500;
`;

const ContentText = styled.p`
    font-size: 20px;
    line-height: 32px;
    white-space: pre-wrap;
`

const CommentLabel = styled.p`
    font-size: 16px;
    font-weitht: 500;
`;

function PostViewPage(props) {
    const navigate = useNavigate();
    const { postId } = useParams();

    const post = data.find((item) => {
        return item.id == postId;
    });
    
    const [comment, setComment] = useState("");

    return(
        <Wrapper>
            <Continer>
                <Button
                    title="뒤로 가기"
                    onClick={() => {
                        navigate("/")
                    }}
                />
                <PostContainer>
                    <TitleText>{post.title}</TitleText>
                    <ContentText>{post.content}</ContentText>
                </PostContainer>

                <CommentLabel>댓글</CommentLabel>
                <CommentLabel comments={post.comments} />

                <TextInput
                    height={40}
                    value={comment}
                    onChange={(event) => {
                        setComment(event.target.value);
                    }}
                />
                <Button
                    title="댓글 작성하기"
                    onClick={() =>{
                        navigate("/");
                    }}

                />
            </Continer>
        </Wrapper>
    );

}

export default PostViewPage;