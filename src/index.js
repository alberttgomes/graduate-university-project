import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import {StoreProvider} from 'easy-peasy';
import {store} from './pages/Quiz/Storage/store'



ReactDOM.render(
  <React.StrictMode>
    <StoreProvider store={store}>
    <App />
    </StoreProvider>
  </React.StrictMode>,
  document.getElementById("root")
);
