using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Modelo;

namespace extra
{
    public class Funcionario : Usuario
    {
        private Int32 codigoFuncionario;
        private String apelido;
        private String NomeCompleto;
        private String cargoFunc;
        private String observações;
        private Int32 creci;
        private String estadoCivil;
        private Int32[] telefones;
        private String cpf;
        private String rg;
        private String referencias;

        public int CodigoFuncionario { get => codigoFuncionario; set => codigoFuncionario = value; }
        public string Apelido { get => apelido; set => apelido = value; }
        public string NomeCompleto1 { get => NomeCompleto; set => NomeCompleto = value; }
        public string CargoFunc { get => cargoFunc; set => cargoFunc = value; }
        public string Observações { get => observações; set => observações = value; }
        public int Creci { get => creci; set => creci = value; }
        public string EstadoCivil { get => estadoCivil; set => estadoCivil = value; }
        public int[] Telefones { get => telefones; set => telefones = value; }
        public string Cpf { get => cpf; set => cpf = value; }
        public string Rg { get => rg; set => rg = value; }
        public string Referencias { get => referencias; set => referencias = value; }
    }
}
