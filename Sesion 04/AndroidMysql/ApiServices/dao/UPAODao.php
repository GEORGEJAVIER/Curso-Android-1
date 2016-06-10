<?php

require_once '../ds/MyPDO.php';

class UPAODao extends MyPDO {

    
    
    public function consultarCliene($codigo) {
        $rec = null;
        try {
            
            $query = "select chr_cliecodigo, vch_cliepaterno, vch_cliematerno, 
				vch_clienombre, chr_cliedni, vch_clieciudad, vch_cliedireccion, 
				vch_clietelefono, vch_clieemail 
				from Cliente where chr_cliecodigo = ?";
            $stm = $this->pdo->prepare($query);
            $stm->bindParam(1, $codigo);
            $stm->execute();
            $rec = $stm->fetch(PDO::FETCH_ASSOC);
        } catch (Exception $e) {
            throw $e;
        }
        return $rec;
    }

    public function consultarMovimientos($cuenta) {
        $lista = null;
        try {
            $query = "SELECT 
 	concat_ws(' ',cl.vch_cliepaterno,cl.vch_cliematerno,cl.vch_clienombre) as nombres,
	tm.vch_tipodescripcion, 
	m.dec_moviimporte, 
	m.dtt_movifecha, 
	c.dec_cuensaldo
FROM tipomovimiento tm
JOIN movimiento m ON tm.chr_tipocodigo = m.chr_tipocodigo 
JOIN cuenta c on c.chr_cuencodigo=m.chr_cuencodigo
JOIN cliente  cl on cl.chr_cliecodigo=c.chr_cliecodigo
where m.chr_cuencodigo = ? and 	tm.vch_tipodescripcion !='Cargo por Movimiento'
order by m.dtt_movifecha desc ";

            $stm = $this->pdo->prepare($query);
            $stm->bindParam(1, $cuenta);
            $stm->execute();
            $lista = $stm->fetchAll(PDO::FETCH_ASSOC);
        } catch (Exception $e) {
            throw $e;
        }
        return $lista;
    }
}

?>
