# Curso-Android
Aplicacion AppUPAO, este proyecto te permite realizar lo siguientes

- Consulta de datos de clientes
- Realizar depositos y retiros
- Consultar de movimientos de una cuenta.

Pasos
=====
1.- Clonar el respositorio : git clone ..

2.- (s4procdetreti)
  Crear los procedimientos almacenados
  de deposito y retiro

3.- (s4upaodaophp)
  Implementacion de metodos de UPAODao.php
  -login
  -deposito
  -retiro

4.- (s4servicephp)
  Implementacion de metodos login, deposito y retiro.

5.- (s4disenoactivity)

    Login
    ======
    Java :LoginActivity
    Layout: activity_login

    Main
    ====
    Layout: Agregar botones deposito y retiro
            Agregar TextView 


    Deposito
    ========
    Java :DepositoActivity
    Layout: activity_deposito

    Retiro
    ========
    Java :RetiroActivity
    Layout: activity_retiro

    Movimiento
    ==========
    Layout: Agregar TextView cliente, cuenta y saldo

6.- (s4javaactivitys)

    Util
    =====
    Agregar variables static de nombre_empleado y codigo_empleado
    el cual sera usaso en los demas activitys

    LoginActivity
    ==============
    Implementacion del metodo onClickIngresar

    MainActivity
    ============
    Agregar el codigo para que el activity inicie sea 
    activity_login.

    Implementacion de metodos onClickRetiro y onClickDeposito

7.- (s4javadepositoretiro)

    DepositoActivity
    =================
    Implementacion de metodos onClickAceptar y onCLickRetornar

    RetiroActivity
    ==============
    Implementacion de metodos onClickIngresar y onCLickRetornar

8.- (s4javamovimientos)

    MovimientosActivity
    ===================
    Agregar TAG_CLIENTE y TAG_SALDO
    tvcliente.setText("Cliente: " + e.getString(TAG_CLIENTE));
    tvcuenta.setText("Cuenta: " + etCuenta.getText());
    tvsaldo.setText("Saldo: "+e.getString(TAG_SALDO));


