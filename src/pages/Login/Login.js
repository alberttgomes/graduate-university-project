import React from "react";
import "./Login.css";
import "../../components/navbar/Navbar.css"
import Button2 from "../../components/UI/Button/Button";
import { Button } from "@mui/material";
import Denuncia from "../../components/denuncia/Denuncia";
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { AuthContext } from "../../contexts/userContext";
import { useRef, useState, useEffect, useContext } from "react";
import axios from "axios";


const Login = () =>{

  const errRef = useRef();
  const [user, setUser] = useState("");
  const [pwd, setPwd] = useState("");
  const [errMsg, setErrMsg] = useState("");
  const [success, setSuccess] = useState(false);

  const header = {
    "Authorization": "Bearer ",
    "Content-Type": "application/json"
}

  const {result, setResult} = useContext(AuthContext);
  const theme = createTheme();

  const handleSubmit = async (e) => {

    e.preventDefault();
    try{
        const  response = await axios.post('http://localhost:8080/login/auth', JSON.stringify({ user, pwd }), header);
        
      const accessToken = response?.data?.accessToken;
      const roles = response?.data?.roles;

      setResult({ user, pwd, roles, accessToken });
      setUser("");
      setPwd("");
      setSuccess(true);

      console.log("Login efetuado!  :")
    }catch (err){
      console.log("Não pegou:", errMsg)
      if (!err?.response) {
        setErrMsg("No Server Response");
      } else if (err.response?.status === 400) {
        setErrMsg("Missing Username or Password");
      } else if (err.response?.status === 401) {
        setErrMsg("Unauthorized");
      } else if (err.response?.status === 403) {
        setErrMsg("acesso negado");
      } else {
        setErrMsg("Login Failed",);
      } 

    }

    


  }

return (
  <div >
    <ThemeProvider theme={theme} >
            <div className="login">
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
                        <h1 className="title">Login</h1>

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
                                        id="mail"
                                        type='email'
                                        label="Email"
                                        name="Email"
                                        autoComplete="Email"
                                        onChange={(e) => setUser(e.target.value)}
                                        value={user}
                                    />
                                </Grid>
                                <Grid item xs={12}>
                                    <TextField 
                                        required
                                        fullWidth
                                        id="password"
                                        type='password'
                                        label="password"
                                        name="Password"
                                        autoComplete="Password"
                                        onChange={(e) => setPwd(e.target.value)}
                                        value={pwd}
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
                                onClick={handleSubmit}
                            >
                                Entrar
                            </Button>

                            <Grid
                                container justifyContent="flex-end"
                            >
                                <Grid item>
                                    <Link
                                        sx={{
                                          fontSize: 14,
                                        }}
                                        href="/cadastro" variant="body2"
                                    >
                                        Não tem uma conta? Cadastre-se
                                    </Link>
                                </Grid>
                            </Grid>
                        </Box>
                    </Box>
                    <div className="btn-denuncia">
                        <Denuncia></Denuncia>
                    </div>
                    
                </Container>
            </div>
        </ThemeProvider>
  </div>
  );
};

export default Login;
