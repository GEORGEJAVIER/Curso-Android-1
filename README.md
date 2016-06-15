# AppUPAOBANK
Aplicacion AppUPAOBANK, este proyecto te permite realizar lo siguiente:

- Consulta de datos de clientes
- Realizar depositos y retiros
- Consultar de movimientos de una cuenta.

1.- Clonar el respositorio 

    =======================
    git clone https://github.com/gitHAMP/Curso-Android.git

2.- (s4procdetreti)
    
    =======================
    Crear los procedimientos almacenados
    de deposito y retiro

3.- (s4upaodaophp)
    
    =======================
    Implementacion de metodos de UPAODao.php
    -login
    -deposito
    -retiro

4.- (s4servicephp)
    
    =======================
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

9.- Desafio APPUPAOBANK
- Implementar registrar cliente.
- Implementar registrar sucursal 


# AppTvShow
Esta aplicacion utilizar retrofit para consumir un API Rest el cual esta hecho en NODEJS

- Registro de TvShows
- Lista de TvShows

1.- (master)

  ===================
  - Clonar el repositorio https://github.com/gitHAMP/Curso-Android.git
  - Crear Fragment RegistroTvshow, ListarTvshows
  - Crear los layout activity_registro_tvshow,fragment-item_grid y fragment_item_list

2.- (s5models)

   ===================
  - Creando modelo Tvshow.java

3.- (s5InterfaceAPIService)

    ===================
  - Colocando las dependencias en el gradle
  - Colocando en el manifiesto android
     <uses-permission android:name="android.permission.INTERNET" />
  - Sincronizar las dependencias
  - Creando la interface APIService.java

4.- (s5RestClient)

   ===================
   - Crear clase RestClien

5.- (s5MainActivity)

    ===================
   - Implementacion de registroTvShows
   - Implementacion de ListarTvShows

6.- (s6MainActivity1)

    ===================
   - Implementacion de MainActivity
    

