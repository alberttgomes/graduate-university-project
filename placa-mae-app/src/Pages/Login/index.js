import React, { useContext, useState } from "react";
import { View, Text, StyleSheet, TextInput } from 'react-native';

import { AuthContext } from '../../contexts/auth';

import { Button, Divider } from "react-native-paper";

const Login = () => {
    const [email, setEmail] = useState();
    const [password, setPassword] = useState();

    const { signIn } = useContext(AuthContext);
    
    const handleLogin = () => {
        signIn(email, password);
    }

    return(
        <View style={styles.container}>
            <Text>Welcome, {{ name: 'Albert'}} !</Text>
            
            <TextInput 
                style={styles.input}
                value={email}
                onChangeText={(text) => setEmail(text)}
                placeholder='Write your email'
            />
            <Divider />
            <TextInput 
                style={styles.input}
                value={password}
                onChangeText={(text) => setPassword(text)}
                placeholder='Write your password'
            />
            
            <Button
                onPress={() => {handleLogin}}
                icon="check" 
                mode="contained"
                style={styles.button}
            >
                Log In
            </Button>
            <View>
                <Card>
                    <Text>Register is here</Text>
                    <Button style={styles.button} icon="camera" mode="outlined" onPress={() => {}}>
                        Sign In
                    </Button>
                </Card>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container:{
        flex:1,
        justifyContent:'center',
        alignItems:'center'
    },
    input:{
        width: '90%',
        height: 45,
        backgroundColor: '#A7A7A7',
        borderRadius: 4,
        marginBottom: 14,
        padding: 8
    },
    button:{
        width: '90%',
        height: 45,
        borderRadius: 4,
        justifyContent: 'center',
        alignItems: 'center'
    }
});

export default Login;