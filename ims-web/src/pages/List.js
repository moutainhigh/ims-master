import React from 'react'

class List extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            dataList: [1, 2, 3],
            maxNum: 3
        }
    };

    render(){
        return (
            <div>
                <ul>
                    {this.state.dataList.map((value,index) =>{
                        return <li key={index}>{value}</li>
                    })}
                </ul>
            </div>
        );
    }
}

export default List;