import React from 'react';
import styled from 'styled-components';
import { DropArea } from '../components/DropArea';

const FlexParent = styled.div`
    display: flex;
    height: 100%;
`;

export class FileDisplay extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            files: []
        }
    }

    handleDrop = (files) => {
        let fileList = this.state.files;
        files.map((file) => (file.name) ? fileList.push(file.name) : null);
        this.setState({files: fileList})
    };

    render() {
        return (
            <FlexParent>
                <DropArea handleDrop={this.handleDrop}>
                    <React.Fragment/>
                </DropArea>
            </FlexParent>
        );
    }
}
