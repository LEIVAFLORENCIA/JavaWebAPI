import React from 'react'

class Clases extends React.Component {

    state = {
        contador: 1
    }
    render() {
        return (<div>{"contador: " + this.state.contador}
            <div>
                <button onClick={() => { 
                    this.setState({ contador: this.state.contador + 1 });
                    console.log(this.state.contador);
                }}>Aumentar</button>
            </div></div>);
    }
}

export default Clases;