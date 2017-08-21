import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.marketplaceentitlement.AWSMarketplaceEntitlementClient;
import com.amazonaws.services.marketplaceentitlement.model.GetEntitlementsRequest;
import com.amazonaws.services.marketplaceentitlement.model.GetEntitlementsResult;



public class GetAWSEntitlements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GetEntitlementsRequest entitlementRequest = new GetEntitlementsRequest();
		
		// set product code
		entitlementRequest.setProductCode("812fia8oXXXXX");

		// create filter for single customer identifier
		Map<String,List<String>> entitlementFilter = new HashMap<String,List<String>>();
		
		// customer identifier you get using resolveCustomer, this is optional
		List<String> customerIdentifier = new ArrayList<String>();
		customerIdentifier.add("E1o2XXXXX");
		entitlementFilter.put("CUSTOMER_IDENTIFIER", customerIdentifier);
		
		// set entitlement request.
		entitlementRequest.setFilter(entitlementFilter);

		// create aws credential, provide ur appkey and secret key
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIXXXXXXXX", "0lKs8XXXX");
		
		AWSMarketplaceEntitlementClient oClient = (AWSMarketplaceEntitlementClient) AWSMarketplaceEntitlementClient.builder()
				.withRegion(Regions.US_EAST_1)
				
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
		
		GetEntitlementsResult oEntitlementResults = oClient.getEntitlements(entitlementRequest);
		
		System.out.print("hello");

	}

}
