import React, { createContext, useState } from "react";

const defaultState = {
    user: {
        age:'',
        email:'',
        password:'',
        username:''
    },
    registered: false,
}

export const AuthContext = createContext({defaultState});

const AuthProvider = ({ children }) => {
    const [result, setResult] = useState({defaultState});

    return(
        <AuthContext.Provider
            value={{result, setResult}}
        >
            {children}
        </AuthContext.Provider>
    )
}

export default AuthProvider;

    