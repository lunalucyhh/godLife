import React from 'react';
import {
	BrowserRouter as Router,
	Routes,
	Route,
	BrowserRouter
} from 'react-router-dom';

import Login from 'component/member/Login';
import styles from 'css/App.css';

	
function App() {
	return (
		<BrowserRouter>
			<div class="container">
				Hello World
				<Routes>
					<Route path="/" element={<Login />} />
					<Route path="/board" element={<BoardList />} />
					<Route path="/post/:postId" element={<PostViewPage />} />
				</Routes>
			</div>
		</BrowserRouter>
			
	)
}	

export default App;