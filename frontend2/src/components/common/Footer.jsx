import React from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";


function Footer(props){

    return 
      <footer>
        <h2>갓생살기</h2>
          <nav>
            <ul>
              <li><a href="#">문의사항</a></li>
              <li>godLife갓생살기</li>
              <li>02-####-####</li>
            </ul>
            
          </nav>
      </footer>
  }
  
  export default Footer;