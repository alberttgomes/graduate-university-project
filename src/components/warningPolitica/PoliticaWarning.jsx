import React, {useState} from "react";

import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Collapse from '@mui/material/Collapse';

const Warning = () => {
    const [open, setOpen] = useState(true);

    return (
        <Box 
          sx={{
            alignItems: 'center',
            borderRadius: 2,
            fontSize: '0.875rem',
            fontWeight: '700',
            float: 'bottom',
            position: 'absolute',
            mt: -12,
            zIndex: 'modal',
            width: '100%'
          }}
        >
          <Collapse in={open} sx={{width: '80%', margin: 'auto'}}>
              <Alert
                  severity="warning"
                  action={
                      <Button 
                        color="inherit" 
                        size="medium"
                        onClick={
                          () => {
                            setOpen(false)
                          }
                        }
                        sx={{
                          mt:1
                        }}
                      >
                        Prosseguir
                      </Button>
                  }
              >   
                  <AlertTitle
                    sx={{
                      fontWeight: 'bold',
                      fontSize: '1.25rem',
                    }}
                  >
                      Política
                  </AlertTitle>
                  Conheça nossa política de proteção aos seus <strong>dados.</strong>
              </Alert>
          </Collapse>    
        </Box>
    );
}

export default Warning;
