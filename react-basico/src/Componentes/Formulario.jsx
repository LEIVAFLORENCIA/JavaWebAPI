import React from 'react';
import "../recursos/CSS/form.css";
import "../recursos/CSS/button.css";

export default class Formulario extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            first_name:'',
            last_name:'',
            email:''
        }
    }

    asignarValoresFormulario = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    enviarValoresFormulario = (event) => {
        event.preventDefault();
        // enviar datos

        console.log("Enviando formulario");
        this.limpiarValoresFormulario();
    }

    limpiarValoresFormulario = () => {
        this.setState({
            first_name: "",
            last_name: "",
            email: ""
        });
    }


    render() {
        return (
            <>
                <form>
                    <input
                        id='first_name'
                        name='first_name'
                        type='text'
                        placeholder='Ingrese el nombre'
                        required={true}
                        value={this.state.first_name}
                        onChange= {this.asignarValoresFormulario}
                    />
                    <input
                        id='last_name'
                        name='last_name'
                        type='text'
                        placeholder='Ingrese el apellido'
                        required={true}
                        value={this.state.last_name}
                        onChange= {this.asignarValoresFormulario}
                    />
                    <input
                        id='email'
                        name='email'
                        type='email'
                        placeholder='Ingrese el correo'
                        required={true}
                        onChange= {this.asignarValoresFormulario}
                    />
                    <div>
                        <button type='submit' className='success'>Agregar Usuario</button>
                        <button onClick={this.limpiarValoresFormulario} type='reset' className='warning'>Limpiar formulario</button>
                    </div>
                </form>

            </>
        )
    }
}