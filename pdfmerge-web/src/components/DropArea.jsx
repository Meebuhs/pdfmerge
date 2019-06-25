import React from 'react';
import styled from 'styled-components';
import { DropOverlay } from 'components/DropOverlay';

const Container = styled.div`
    border: 1px solid white;
    height 720px;
    width: 100%;
    position: relative;
`;

export class DropArea extends React.Component {
    constructor(props) {
        super(props);
        this.dragCounter = 0;
        this.state = {
            dragging: false
        };
    }

    handleDragIn = (event) => {
        event.preventDefault();
        event.stopPropagation();

        this.dragCounter++;

        if (event.dataTransfer.items && event.dataTransfer.items.length > 0) {
            this.setState({
                dragging: true
            })
        }
    };

    handleDragOut = (event) => {
        event.preventDefault();
        event.stopPropagation();

        this.dragCounter--;
        if (this.dragCounter > 0) {
            return
        }

        this.setState({
            dragging: false
        })
    };

    handleDrag = (event) => {
        event.preventDefault();
        event.stopPropagation();
    };

    handleDrop = (event) => {
        event.preventDefault();
        event.stopPropagation();
        this.setState({dragging: false});
        if (event.dataTransfer.files && event.dataTransfer.files.length > 0) {
            this.props.handleDrop(event.dataTransfer.files);
            event.dataTransfer.clearData();
            this.dragCounter = 0
        }
    };

    render() {
        return (
            <Container
                onDragEnter={this.handleDragIn}
                onDragLeave={this.handleDragOut}
                onDragOver={this.handleDrag}
                onDrop={this.handleDrop}
            >
                {(this.state.dragging) ? (<DropOverlay />) : null}
                {this.props.children}
            </Container>
        );
    }
}
