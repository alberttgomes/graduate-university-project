import React, { useContext, useState, useEffect } from "react";
import AppBar from '@mui/material/AppBar';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Avatar from '@mui/material/Avatar';
import { Link } from "react-router-dom";
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import { ItemMenu } from './ItemMenu';
import { AuthContext } from '../../contexts/userContext';

const pages = ['Home', 'Material', 'Sobre', 'Jogos', 'Quiz'];
const settings = ['Perfil', 'Conta', 'Dashboard', 'Sair'];

const Navbar = () => {
  const [anchorElNav, setAnchorElNav] = useState(null);
  const [anchorElUser, setAnchorElUser] = useState(null);

  const {result, setResult} = useContext(AuthContext);

  useEffect(() => {
    console.log(result);
  }, [result])

  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
  };

  return (
    <AppBar position="static">
      <div className="navbar">
        <Toolbar sx={{ flexWrap: 'wrap' }}>
          <Box sx={{ flexGrow: 1, display: { xs: 'flex', md: 'none' } }}>
            <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}
              color="inherit"
            >
              <MenuIcon />
            </IconButton>
            <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: 'bottom',
                horizontal: 'left',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'left',
              }}
              open={Boolean(anchorElNav)}
              onClose={handleCloseNavMenu}
              sx={{
                display: { xs: 'block', md: 'none' },
              }}
            >
              {pages.map((page) => (
                <MenuItem key={page} onClick={handleCloseNavMenu}>
                  <Typography textAlign="center">{page}</Typography>
                </MenuItem>
              ))}
            </Menu>
          </Box>
          
          <Box 
             sx={{ 
                flexGrow: 1, 
                display: { 
                    xs: 'none', md: 'flex' 
                } 
             }}
             className="menu"
          >
                {result?.registered === false
                  ? <ItemMenu>
                        <Link 
                          to="/"
                        >
                            Inicio
                        </Link>
                    </ItemMenu>
                  : <ItemMenu>
                        <Link
                          to={`/`}
                        >
                            Inicio
                        </Link>
                    </ItemMenu>  
                },
                {result?.registered === false
                    ? <ItemMenu>
                          <Link 
                              to="/material"
                          >
                              Material
                          </Link>
                      </ItemMenu> 
                    : <ItemMenu>
                          <Link 
                              to="/materialCategorizado"
                          >
                              Material
                          </Link>
                      </ItemMenu>
                },
                <ItemMenu>
                    <Link
                        to="/sobre"
                    >
                        Sobre
                    </Link>
                </ItemMenu>
                <ItemMenu>
                    <Link
                        to="/jogos"
                    >
                        Jogos
                    </Link>
                </ItemMenu>
                {result?.registered === true?
                  <ItemMenu>
                    <Link
                        to="/quiz"
                    >
                        Quiz
                    </Link> 
                    
                  </ItemMenu> : null  
                },
                {result?.registered === false
                    ? <div className="buttonLogin">
                        <ItemMenu>
                          <Link
                              to="/login"
                          >
                              Entrar
                          </Link> 
                        </ItemMenu>
                      </div>
                    : null  
                }
                {result?.registered === false
                    ? <div>
                        <Button
                          className="nav-links"
                          sx={{
                            background:" #FAE43C"
                          }}
                        >
                            <Link 
                                to="/cadastro"
                            >
                                Cadastre-se
                            </Link>
                        </Button>
                      </div>
                    : null  
                }
                {/* <Box
                  sx={{ 
                    flexGrow: 1, 
                    display: { 
                        xs: 'none', md: 'flex' 
                    } 
                  }}
                >
                    <SwitchTheme />
                </Box> */}
          </Box>
          {result?.registered === true?
                <Box sx={{ flexGrow: 0 }}>
                    <Tooltip title="Configuracoes">
                      <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
                        <Avatar alt="user-avatar" src="" />
                      </IconButton>
                    </Tooltip>
                    <Menu
                      sx={{ mt: '45px' }}
                      id="menu-appbar"
                      anchorEl={anchorElUser}
                      anchorOrigin={{
                        vertical: 'top',
                        horizontal: 'right',
                      }}
                      keepMounted
                      transformOrigin={{
                        vertical: 'top',
                        horizontal: 'right',
                      }}
                      open={Boolean(anchorElUser)}
                      onClose={handleCloseUserMenu}
                    >
                      {settings.map((setting) => (
                        <MenuItem key={setting} onClick={handleCloseUserMenu}>
                          <Typography textAlign="center">{setting}</Typography>
                        </MenuItem>
                      ))}
                    </Menu>
                </Box> : null
          }
          
        </Toolbar>
        </div>
    </AppBar>
  );
};

export default Navbar;
