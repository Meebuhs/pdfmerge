import React from 'react';
import styled from 'styled-components';

const Container = styled.div`
    width: 100%;
    height: 70px;
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
`;

const Button = styled.div`
    background-color: #b8b8b8;
    text-align: center;
    margin: 10px 0;
    height: 50px;
    width: 125px;
    vertical-align: middle;
    line-height: 50px;
    border-radius: 2px;
    cursor: pointer;
    
    :hover {
        background-color: #f2f2f2;
    }
    
    :active {
        background-color: #e5e5e5;
    }
    
    ${({disabled}) => disabled && `
        opacity: 0.5;
    `}
`;

export class ToolBar extends React.Component {
    render() {
        return (
            <Container>
                <Button>
                    Merge
                </Button>
            </Container>
        );
    }
}
