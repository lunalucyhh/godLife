import logo from './logo.svg';
import './App.css';
import {
  BrowerRouter,
  Routes,
  Route,
  BrowserRouter
} from "react-router-dom";
import styled from 'styled-components';
//page
import MainPage from './pages/MainPage';
import PostwritePage from './pages/PostWritePage';
import PostViewPage from './pages/PostViewPage';


const MainTitleText = styled.p`
  font-size 24px
`;


function App() {
  return (
    <BrowserRouter>
      <MainTitleText>갓생살기</MainTitleText>
      <Routes>
        <Route index element={<MainPage/ >} />
        <Route path="post-write" element={<PostwritePage />} />
        <Route path="post/:postId" element={<PostViewPage />} />

      </Routes>
    </BrowserRouter>
    
  );
}

export default App;
