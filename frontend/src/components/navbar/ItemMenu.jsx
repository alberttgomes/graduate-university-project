import React from "react";
import Button from '@mui/material/Button';

export const ItemMenu = ({ children }) => {
     return(
        <Button
          sx={{ my: 2 }}
          className="nav-links"
        >
            {children}
        </Button>
     );
}