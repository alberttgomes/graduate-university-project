import React, { createContext, useState } from 'react';

import { useNavigation } from '@react-navigation/native';

export const AuthContext = createContext({});

const AuthProvider = ({children}) => {
    const [user, setUser] = useState({});
    const navigation = useNavigation();

    const signIn = (email, password) => {
        if(email !== '' && password !== ''){
            setUser({
                email: email,
                status: 'Active'
            });

            navigation.navigate('Home');

        }
    }

    return(
        <AuthContext.Provider value={{signIn, user}}>
            {children}
        </AuthContext.Provider>
    );
}

export default AuthProvider;
