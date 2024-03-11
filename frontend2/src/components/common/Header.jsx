import React from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";

const header = styled.div`
  padding: 16px;
  width: calc(100% - 32px);
  display: flex;

`;


function Header(){
    return 
      <header>
        <h2>갓생살기</h2>
          <nav>
            <ul>
              <li><a href="#">소개</a></li>
            </ul>
            <ul>
              <li><a href="#">로그인</a></li>
              <li><a href="">회원가입</a></li>
            </ul>
          </nav>
      </header>
  }
  
  export default Header;


  /*
     <h1><a href="/" onClick={(event)=>{
        event.preventDefault();
        props.onChangeMode();
      }}>{props.title}</a></h1>
   
  */