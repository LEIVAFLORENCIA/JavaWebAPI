function Funciones(props) {

    let contador = 1;

    return (

        <div>
            <h1>Titulo</h1>
            <h2>Subtitulo</h2>
            <h3>Parrafo</h3>
            <button onClick={() => {
                contador++;
                console.log("Pulsando boton, contador: " + contador)
            }}>
                Aumentar contador</button>
        </div>

    );
}

// En este archivo puedo tener varias funciones pero acá yo defino qué return va a devolver si yo la llamo
export default Funciones;