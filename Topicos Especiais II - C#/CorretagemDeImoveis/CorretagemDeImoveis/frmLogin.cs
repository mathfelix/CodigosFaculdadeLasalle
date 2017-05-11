using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Modelo;
using Controle;

namespace CorretagemDeImoveis
{
    public partial class frmLogin : Form
    {
        Usuario usuario;

        public frmLogin()
        {
            InitializeComponent();
        }

        private void btnLogar_Click(object sender, EventArgs e)
        {
            try
            {
                usuario = new Usuario();
                usuario.User = txbUsuario.Text;
                usuario.Password = txbSenha.Text;
                

                if (UsuAutenticacao.ValidarUsuario(usuario))
                {
                    
                    this.Tag = usuario;
                    this.DialogResult = DialogResult.Yes;
                    this.Close();
                    
                }
                else
                {
                    lblMsgErro.Text = "Usuario ou senha incorretos!";
                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("Erro: " + ex.Message);
            }

        }

        private void LimparMsgErro()
        {
            lblMsgErro.Text = "";
        }

        private void txb_Changed(object sender, EventArgs e)
        {
            LimparMsgErro();
        }

        public Usuario getUsuario()
        {
            return usuario;
        }

        private void frmLogin_Load(object sender, EventArgs e)
        {

        }
    }
}
