import React, { createContext, FC, useState } from "react";

type IpropsChildren = {
    children: React.ReactNode;
}

type IPropsTypes = {
    result?: IPropsContext;
    setResult: (newValue: IPropsContext) => void;
}

interface IPropsContext {
    user: {
        age: string,
        email: string,
        password: string,
        username: string 
    },
    registered: boolean,
    scoreQuiz: number
}

const defaultState = {
    user: {
        age:'',
        email:'',
        password:'',
        username:''
    },
    registered: false,
    scoreQuiz: 0,
}

export const AuthContext = createContext<IPropsTypes>(
    {result: defaultState, setResult: result => {console.log(result)}});

const AuthProvider: FC<IpropsChildren>= ({ children }) => {
    const [result, setResult] = useState<IPropsContext>(defaultState);

    return(
        <AuthContext.Provider
            value={{result, setResult}}
        >
            {children}
        </AuthContext.Provider>
    );
    
}

export default AuthProvider;

