import React from 'react';
import ReactDOM from 'react-dom';
import 'utils/reset.css'
import styled from 'styled-components';
import { FileDisplay } from 'containers/FileDisplay';

const Container = styled.div`
    width: 100vw;
    height: 100vh;
    display: flex;
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