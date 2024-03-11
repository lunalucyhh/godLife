import './App.css';
import ReactDOM from 'react-dom/client';
import { useState } from 'react';
import { BrowserRouter,Route,Routes } from 'react-router-dom';
import styled from 'styled-components';

//Pages
import Main from './pages/Main';
import PostWritePage from './pages/board/PostWritePage'
import PostViewPage from './pages/board/PostViewPage'
import Header from './components/common/Header';
import Footer from './components/common/Footer';
import NotFound from './pages/NotFound';

function App () {
  return (

      <BrowserRouter>
        <Header></Header>
        <Routes>
          <Route index path="/" element={<Main/ >} />
          <Route path="post-write" element={<PostWritePage />} />
          <Route path="post/:postId" element={<PostViewPage />} />
          <Route path="*" element={<NotFound />}></Route>
        </Routes>
        <Footer></Footer>
      </BrowserRouter>

    )
}
export default App;