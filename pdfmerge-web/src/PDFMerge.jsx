import React from 'react';
import ReactDOM from 'react-dom';
import { FileDisplay } from 'containers/FileDisplay'
import 'utils/reset.css'
import styled from 'styled-components';

const Container = styled.div`
    width: 100vw;
    height: 100vh;
    background-color: #3c3c3c;
`;

class PDFMerge extends React.Component {
    render() {
        return (
            <Container>
                <FileDisplay />
            </Container>
        );
    }
}

ReactDOM.render(<PDFMerge />, document.getElementById('root'));