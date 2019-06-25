import React from 'react';
import styled from 'styled-components';

const Border = styled.div`
    border: dashed grey 3px;
    background-color: rgba(255,255,255,.8);
    height: 100%;
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    z-index: 1;
    display: flex;
`;

const Overlay = styled.div`
    margin: auto;
    text-align: center;
    color: grey;
    font-size: 10em;
`;

export class DropOverlay extends React.Component {
    render() {
        return (
                <Border>
                    <Overlay>
                        +
                    </Overlay>
                </Border>
        );
    }
}