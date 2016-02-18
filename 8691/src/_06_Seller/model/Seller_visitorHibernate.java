package _06_Seller.model;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import _06_Seller.model.Seller_visitorDAO;
import _06_Seller.model.Seller_visitorBean;
import hibernate.HibernateUtil;

	public class Seller_visitorHibernate implements Seller_visitorDAO {
		private SessionFactory sessionFactory;
		public Seller_visitorHibernate() {
			sessionFactory = HibernateUtil.getSessionFactory();
		}
		public Session getSession() {
			if(sessionFactory!=null) {
				return sessionFactory.getCurrentSession();
			}
			return null;
		}
		public static void main(String[] args) {
			try {
				HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
 
				Seller_visitorDAO dao = new Seller_visitorHibernate();
	//select all
//				List<Seller_visitorVO> beans = dao.select();
//				System.out.println(beans);
				
	//select 單一id
//				Seller_visitorVO bean = dao.select("29874195");
//				System.out.println(bean);
					
	//update  
//				boolean beanupdate = dao.update("29874195","ooxx","ooxxhi@gmail.com","ooxx@@",null,"0228825252","A","100","1","37號五樓","ooxxhi@hotmail.com","王大陸","0954778878","1",true,true,new java.util.Date());
//				System.out.println(beanupdate);
				
	// insert    
				Seller_visitorVO beanIns = new Seller_visitorVO("00112233","0123","3210@gmail.com","3210",null,"0223322111","A","104","230","112號7樓之一","00332211@hotmail.com","趙00","0944332211","0",false,false,new java.util.Date());				
				dao.insert(beanIns);
				
	// delete    
//				int beanDel = dao.delete("00112233");
//				System.out.println(beanDel);		
				HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
			} finally {
				HibernateUtil.closeSessionFactory();
			}
		}
		
		

		@Override
		public Seller_visitorVO select(String id) {
			return (Seller_visitorVO) getSession().get(Seller_visitorVO.class, id);
		}		
		@Override
		public List<Seller_visitorVO> select() {
			return getSession().createQuery("from Seller_visitorVO").list();
		}
		@Override
		public boolean update(String FEIN, String name,String acc_email,String psd,Blob Seller_photo,String	tel,String	GUAR_CT,String	GUAR_AR,String	GUAR_AR_name,String	GUAR_NO,String	email2,String Con_name,String	Con_cel,String	receipts_metho,boolean IS_check,boolean IS_cooperation,java.util.Date insdate) {
			Seller_visitorVO bean = (Seller_visitorVO) getSession().get(Seller_visitorVO.class, FEIN);
			if(bean!=null) {
				bean.setFEIN(FEIN);
				bean.setName(name);
				bean.setAcc_email(acc_email);
				bean.setPsd(psd);
				bean.setSeller_photo(Seller_photo);
				bean.setTel(tel);
				bean.setGUAR_CT(GUAR_CT);
				bean.setGUAR_AR(GUAR_AR);
				bean.setGUAR_AR_name(GUAR_AR_name);
				bean.setGUAR_NO(GUAR_NO);
				bean.setEmail2(email2);
				bean.setCon_name(Con_name);
				bean.setCon_cel(Con_cel);
				bean.setReceipts_metho(receipts_metho);
				bean.setIS_check(IS_check);
				bean.setIS_cooperation(IS_cooperation);
				bean.setInsdate(insdate);
				return true;
			}
			return false;
		}
		@Override
		public Seller_visitorVO insert(Seller_visitorVO bean) {
			Seller_visitorVO temp = (Seller_visitorVO) this.getSession().get(Seller_visitorVO.class, bean.getFEIN());
			if (temp==null) {
				this.getSession().save(bean);
				return bean;
			}
			return null;
		}
		
	//delete
		@Override
		public int delete(String FEIN) {
			Seller_visitorVO bean = (Seller_visitorVO) getSession().get(Seller_visitorVO.class, FEIN);
			if(bean!=null) {
				getSession().delete(bean);
				return 1;
			}
			return 0;
		}

	}