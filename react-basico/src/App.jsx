import React, { Component } from 'react';
import Avatar from "../src/recursos/imagenes/avatar.png"

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            usuarios: []
        }
    };

    buscarUsuarios = () => {
        //promesas
        const URL = "https://reqres.in/api/users";
        fetch(URL)
            .then( (response) => response.text() )
            .then( (text) => console.log(text))
    }

    render() {
        return (
            <>
                <button onClick={this.buscarUsuarios}>Buscar datos</button>
            </>
        );
    }

}
export default App;