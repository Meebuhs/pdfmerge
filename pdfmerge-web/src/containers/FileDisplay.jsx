import React from 'react';
import styled from 'styled-components';
import { DropArea } from 'components/DropArea';
import { FileIcon } from 'components/FileIcon';
import { ToolBar } from 'components/ToolBar';

const FlexParent = styled.div`
    display: flex;
    flex-direction: column;
    margin: auto;
    
    @media screen and (max-width: 400px) {
        width: 400px;
    }
    
    @media screen and (min-width: 400px) {
        width: 100%;
    }
    
    @media screen and (min-width: 1280px) {
        width: 1280px;
    }
`;

const FileContainer = styled.div`
    height: 100%
    width: 100%
    display: flex;
    flex-flow: row wrap;
    align-content: flex-start;
    overflow-y: scroll;
`;

class Files extends React.Component {
    shouldComponentUpdate(nextProps) {
        return nextProps.files !== this.props.files;
    }

    render() {
        return this.props.files.map(file => (
            <FileIcon
                key={file.id}
                id={file.id}
                file={file.file}
            />
        ));
    }
}

export class FileDisplay extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            files: []
        }
    }

    handleDrop = (files) => {
        let fileList = Array.from(this.state.files);
        Array.from(files).map((file) => (file.type === "application/pdf") ? fileList.push({
            id: this.createId(file),
            file: file,
        }) : null);
        this.setState({files: fileList})
    };

    createId(file) {
        return [file.name, new Date().getTime()].join('.')
    }

    render() {
        return (
            <FlexParent>
                <DropArea handleDrop={this.handleDrop}>
                    <FileContainer>
                        <Files
                            files={this.state.files}
                        />
                    </FileContainer>
                </DropArea>
                <ToolBar />
            </FlexParent>
        );
    }
}
