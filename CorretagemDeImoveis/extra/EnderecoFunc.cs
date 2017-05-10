using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Modelo;

namespace extra
{
    class EnderecoFunc : Funcionario
    {
        private String endereço;
        private String bairro;
        private String cidade;
        private String estado;
        private Int32 numeroCasa;

        public string Endereço { get => endereço; set => endereço = value; }
        public string Bairro { get => bairro; set => bairro = value; }
        public string Cidade { get => cidade; set => cidade = value; }
        public string Estado { get => estado; set => estado = value; }
        public int NumeroCasa { get => numeroCasa; set => numeroCasa = value; }
    }
}
