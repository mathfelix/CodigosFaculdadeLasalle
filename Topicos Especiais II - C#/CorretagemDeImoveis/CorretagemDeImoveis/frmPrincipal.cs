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

namespace CorretagemDeImoveis
{
    public partial class frmPrincipal : Form
    {
        public frmPrincipal()
        {
            InitializeComponent();
        }

        private void frmPrincipal_Load(object sender, EventArgs e)
        {
            Efetuar_Login();
        }

        private void Efetuar_Login()
        {
            try
            {
                frmLogin form = new frmLogin();
                if (!(form.ShowDialog() == DialogResult.Yes))
                {

                    this.Close();

                }

            }
            catch (Exception ex)
            {
                MessageBox.Show("Erro: " + ex.Message);
               
            }

        }

        private void tmHora_Tick(object sender, EventArgs e)
        {
            lblHora.Text = DateTime.Now.ToLongTimeString();
        }

        private void gpbUsuLogin_Enter(object sender, EventArgs e)
        {
            frmLogin log = new frmLogin();
            Usuario usu = new Usuario();

            usu = log.getUsuario();
           
        }

        private void label14_Click(object sender, EventArgs e)
        {

        }

        private void label19_Click(object sender, EventArgs e)
        {

        }
    }
}
