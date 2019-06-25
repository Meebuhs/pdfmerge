import React from 'react';
import styled from 'styled-components';

const Container = styled.div`
    border: 1px solid white;
    width: 100px;
    height: 100px;
    background-color: red;
    margin: 12px;
`;

export class FileIcon extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: props.id,
            file: props.file
        }
    }

    render() {
        return (
            <Container>
                {this.props.file.name}
            </Container>
        );
    }
}
