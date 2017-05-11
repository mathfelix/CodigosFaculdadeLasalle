using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Modelo;

namespace Controle
{
    public class UsuAutenticacao
    {

        public static bool ValidarUsuario(Usuario user)
        {
            try
            {
                if (user.User.Equals("Mat") && user.Password.Equals("123"))
                {
                    return true;
                }
                else
                {
                    return false;
                }

            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }

        }

        

    }
}
