import React, { useState } from "react";

import Alert from '@mui/material/Alert';
import AlertTitle from '@mui/material/AlertTitle';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Collapse from '@mui/material/Collapse';
import "./Politica.css";

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
        width: '100%',
      }}
    >
      <Collapse in={open} sx={{ width: '80%', margin: 'auto' }}>
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
                mt: 1
              }}
            >
              Prosseguir
            </Button>
          }
        >
          <AlertTitle
            sx={{
              fontWeight: 'bold',
              fontSize: '1.40rem',
            }}
          >
            Política
          </AlertTitle>
          Este site utiliza cookies e outras tecnologias para melhorar a sua experiência.
          <strong> Acesse a nossa política </strong>e entenda o que coletamos e como tratamos os seus dados.
        </Alert>
      </Collapse>
    </Box>
  );
}

export default Warning;
