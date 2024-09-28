import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ProductList from './components/ProductList';
import Cart from './components/Cart';
import Login from './components/Login';

function App() {
    return (
        <Router>
            <Switch>
                <Route path="/" exact component={ProductList} />
                <Route path="/cart" component={Cart} />
                <Route path="/login" component={Login} />
            </Switch>
        </Router>
    );
}

export default App;
