import React from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import PostList from "../components/List/PostList";
import Button from "../ui/Button"

const Wrapper = styled.div`
    padding: 16px;
    width: calc(100% - 32px);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

`;

const Container = styled.div`
    width: 100%;
    max-width:720px;

    & > * {
        :not(:last-child) {
            margin-bottom: 16px;
        }
    }

`;

function MainPage(props) {
    const {} = props;

    const navigate= useNavigate();

    return(
        <Wrapper>
            
            <MainTitleText>갓생살기</MainTitleText>
            <Container>
                <p>당신의 순간을 응원합니다</p>    
            </Container>
        </Wrapper>
    );
}

export default MainPage;