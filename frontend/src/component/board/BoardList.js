import * as React from 'react';
import Header from '../navigation/Header';
import styles from '../../css/App.css';

const sections = [
	{ title: '천천히', url: '#' }
]
function BoardList(props) {
	return (
		<React.Fragment className="font">
			<Header title="갓생살기" sections={sections}/>
		</React.Fragment>
	)
}


export default BoardList;