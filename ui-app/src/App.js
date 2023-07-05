import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';

class App extends Component {
  state = {
    products: []
  };

  async componentDidMount() {
    const response = await fetch('http://localhost:8080/products');
    console.log(response);
    const body = await response.json();
    this.setState({products: body});
  }

  render() {
    const {products} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>Products</h2>
            
               
              
              <table>
              <tr>
              <th>  Id </th><th>Name </th><th>Price  </th>
              </tr>
              
              {products.map(product =>
                  
             <tr>
             <><td> {product.id} </td>
             <td>{product.name}</td>
             <td>{product.price}</td></>
             </tr>
                  
              )}
              
              </table>
        
            </div>
          </header>
        </div>
    );
  }
}
export default App;

