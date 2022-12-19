import React, { useCallback, useContext, useState } from "react";
import "./Cadastro.css";
import Denuncia from "../../components/denuncia/Denuncia";
import { Button } from "@mui/material";
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { AuthContext } from "../../contexts/userContext";
import axios from "axios";
import { useStoreState } from "easy-peasy";

export const AGE_KIDS_BASE = 13;
export const AGE_ADOLESCENTS_BASE = 17;
export const AGE_ADULTS_BASE = 18;

const Cadastro = () => {
    const light = useStoreState(state => state.light)
  const {result, setResult} = useContext(AuthContext);

  const theme = createTheme();

  const [checkPassword, setCheckPassword] = useState("");

  const [userSignUP, setUserSignUP] = useState({
      age: '',
      email:'',
      password:'',
      username:''
  });

  const checkerEmail = (email) => {
      const emailRegex = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
      
      return emailRegex.test(email)
  }

  const handleSave = () => {
    let ageValue = parseInt(userSignUP.age);

    let checkEmail = false;
    
    if(checkerEmail(userSignUP.email)) {
        checkEmail = true;
        console.log('Válido')
    }
    else {
        console.log('Por favor, digite um email válido.')
    }
    
    const header = {
        "Authorization": "Bearer ",
        "Content-Type": "application/json"
    }

    if (checkEmail && checkPassword == userSignUP.password) {
        if(ageValue <= AGE_KIDS_BASE) {
            axios.post('http://localhost:8080/kids', userSignUP, header)
                .then(() => {
                    setResult({user: userSignUP, registered: true})

                    localStorage.setItem(result);

                    window.location.reload(true);

                })
                .catch((error) => {
                    console.log(`An error current in request API ${error}`)
                });
        } 
        else if (ageValue > AGE_KIDS_BASE && ageValue <= AGE_ADOLESCENTS_BASE) {
            axios.post('http://localhost:8080/adolescents', userSignUP, header)
                .then(() => {
                    setResult({user: userSignUP, registered: true})
                    
                    localStorage.setItem(result);

                    window.location.reload(true);

                })
                .catch((error) => {
                    console.log(`An error current in request API ${error}`)
                });
        }
        else if (ageValue >= AGE_ADULTS_BASE) {
            axios.post('http://localhost:8080/adults', userSignUP, header)
                .then(() => {
                    setResult({user: userSignUP, registered: true})

                    localStorage.setItem(result);

                    window.location.reload(true);

                })
                .catch((error) => {
                    console.log(`An error current in request API ${error}`)
                });
        } else {
            console.log('An error happened')
        }
    } 
    else {
        console.log('Senha ou Email formato inválido')
    }
  };

  const Copyright = (props) => {
    return(
        <Typography
            variant="body2"
            color="text.secondary"
            align="center"
            {...props}
        >
           {'Copyright @ '}
           <Link
              color="text.secondary"
              href="https://placamae.org/"
           >
              PlacaMae.ORG        
           </Link> {''}
           {new Date().getFullYear()}
           {'.'}
        </Typography>
    );
  }

  return (
        <ThemeProvider theme={theme}>
            <div style={{backgroundColor :  `${light ? 'white' : '#040017'}`}}>
                <Container
                    component='main' maxWidth='xs'
                >
                    <Box
                        sx={{
                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'center',
                            textTransform: 'capitalize',
                            mt: 1,
                            mb:10,
                            mx: "auto" 
                        }}
                    >
                        <h1 className="title">Cadastre-se</h1>

                        <Box
                            component="form"
                            noValidate
                            sx={{
                                mt: 6,
                                mx: "auto",
                                
                                fontWeight: 'bold' 
                            }}
                        >
                            <Grid
                                container spacing={2}
                            >
                                <Grid item xs={12}>
                                    <TextField 
                                        required
                                        fullWidth
                                        id="age"
                                        type='number'
                                        label="Idade"
                                        name="idade"
                                        autoComplete="Idade"
                                        value={userSignUP.age}
                                        onChange={(event) => {
                                            setUserSignUP({...userSignUP, age: event.target.value});
                                        }}
                                   
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <TextField 
                                        required
                                        fullWidth
                                        id="username"
                                        label="Nome de usuario"
                                        name="Username"
                                        autoComplete="Nome de usuario"
                                        value={userSignUP.username}
                                        onChange={(event) => {
                                            setUserSignUP({...userSignUP, username: event.target.value});
                                        }}
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <TextField 
                                        required
                                        fullWidth
                                        id="email"
                                        label="Email"
                                        background="#fff"
                                        name="Email"
                                        autoComplete="email"
                                        value={userSignUP.email}
                                        onChange={(event) => {
                                            setUserSignUP({...userSignUP, email: event.target.value});
                                        }}
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <TextField 
                                        required
                                        fullWidth
                                        id="password"
                                        label="Senha"
                                        type="password"
                                        name="Senha"
                                        autoComplete="Nova senha"
                                        value={userSignUP.password}
                                        onChange={(event) => {
                                            setUserSignUP({...userSignUP, password: event.target.value});
                                        }}
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <TextField 
                                        required
                                        fullWidth
                                        id="password"
                                        label="Confirmar Senha"
                                        type="password"
                                        name="Senha"
                                        value={checkPassword}
                                        onChange={(event) => {
                                            setCheckPassword(event.target.value);
                                        }}
                                    />
                                </Grid>
                            </Grid>
                            <Button
                                fullWidth
                                variant="contained"
                                sx={{ 
                                    mt: 2, mb: 1,
                                    fontSize: 14,
                                    fontWeight: 'bold',
                                }}
                                onClick={handleSave}
                            >
                                Cadastrar
                            </Button>
                            <Grid
                                container justifyContent="flex-end"
                            >
                                <Grid item>
                                    <Link
                                        sx={{
                                          fontSize: 14,
                                        }}
                                        href="/login" variant="body2"
                                    >
                                        Ja possui uma conta? Entre
                                    </Link>
                                </Grid>
                            </Grid>
                        </Box>
                    </Box>
                    <Copyright sx={{ mt: 3, mb: 3 }} />
                    
                    <div className="btn-denuncia">
                        <Denuncia></Denuncia>
                    </div>
                    
                </Container>
            </div>
        </ThemeProvider>
  );
};

export default Cadastro;
