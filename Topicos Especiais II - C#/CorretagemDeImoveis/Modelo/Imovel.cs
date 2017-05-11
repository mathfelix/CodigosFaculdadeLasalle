using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Modelo
{
    class Imovel
    {
        private Int32 codigoImovel;
        private String situação;
        private String tipoImovel;
        private String proprietario;
        private Int32 numeroImovel;
        private String complemento;
        private Int32 cep;
        private Double preço;
        private String estado;
        private String cidade;
        private String bairro;
        private String endereço;
        private DateTime data;
        private Double areaTotal;


        public int CodigoImovel { get => codigoImovel; set => codigoImovel = value; }
        public string Situação { get => situação; set => situação = value; }
        public string TipoImovel { get => tipoImovel; set => tipoImovel = value; }
        public double Preço { get => preço; set => preço = value; }
        public string Estado { get => estado; set => estado = value; }
        public string Cidade { get => cidade; set => cidade = value; }
        public string Bairro { get => bairro; set => bairro = value; }
        public string Endereço { get => endereço; set => endereço = value; }
        public DateTime Data { get => data; set => data = value; }

    }
}
